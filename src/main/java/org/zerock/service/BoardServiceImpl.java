package org.zerock.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.FileVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.FileMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@AllArgsConstructor // 생성자 생성
@Service // Component
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	private ReplyMapper replyMapper;
	private FileMapper fileMapper;
	
//	@Autowired
//	public BoardServiceImpl(BoardMapper mapper) {
//		this.mapper = mapper;
//	}
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}
	
	@Override
	@Transactional
	public void register(BoardVO board, MultipartFile file) {
		register(board);
		
		if (file != null && file.getSize() > 0) {
			FileVO vo = new FileVO();
			vo.setBno(board.getBno());
			vo.setFileName(file.getOriginalFilename());
			
			fileMapper.insert(vo);
			upload(board, file);
		}
	}
	
	private void upload(BoardVO board, MultipartFile file) {

		try (InputStream is = file.getInputStream()) {
			String bucketName = "choongang-sebaek1";
			String profileName = "spring1";
			S3Client s3 = S3Client.builder()
					.credentialsProvider(ProfileCredentialsProvider.create(profileName))
					.build();
			
			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key(board.getBno() + "/" + file.getOriginalFilename())
					.contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			s3.putObject(objectRequest, 
					RequestBody.fromInputStream(is, file.getSize()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1; // int이기에 하나의 값 리턴 즉 == 1
	}

	@Override
	@Transactional // 하나의 메소드가 일할때 다른 메소드도 같이 일함
	public boolean remove(Long bno) {
		// 댓글 삭제
		replyMapper.deleteByBno(bno);
		
		// 게시물 삭제
		int cnt = mapper.delete(bno);

		return cnt == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}
