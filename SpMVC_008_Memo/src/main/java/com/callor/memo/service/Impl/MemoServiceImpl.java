package com.callor.memo.service.Impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoDao memoDao;

	@Autowired
	private MemoService memoService;

	@Autowired
	private ResourceLoader resLoad;

	@Autowired
	private String upLoadFolder;

	@Override
	public List<MemoVO> selectAll() {
		// TODO Auto-generated method stub
		List<MemoVO> memos = memoDao.selectAll();
		return memos;
	}

	@Override
	public String upFile(MultipartFile file) throws Exception {
		if(file==null) {
			log.debug("파일 널");
			return null;
		}
		File dir = new File(upLoadFolder);
		if (!dir.exists()) {
			dir.mkdirs();
			log.debug("폴더 널");
		}
		String fileName = file.getOriginalFilename();

		String strUUID = UUID.randomUUID().toString();

		fileName = String.format("%s-%s", strUUID, fileName);

		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		return fileName;
	}

	@Override
	public void create_memo_table() {
		// TODO Auto-generated method stub
		try {
			memoDao.create_memo_table();
		} catch (Exception e) {
			log.debug("create_memo_table exception");
		}
	}

	@Override
	public MemoVO findById(Long id) {
		// TODO Auto-generated method stub

		return memoDao.findById(id);
	}

	@Override
	public int insert(MemoVO vo) {
		// TODO Auto-generated method stub

		return memoDao.insert(vo);
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return memoDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return memoDao.delete(id);
	}

	@Override
	public String insertFile(MemoVO memoVO, MultipartFile file){
		// TODO Auto-generated method stub
		
			try {
				String fileName = memoService.upFile(file);
				log.debug("파일네임 변수-------------------",fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.debug("파일 안옴");
				e.printStackTrace();
			}
		MemoVO imageVO = MemoVO.builder().m_image(file.getOriginalFilename()).build();
		log.debug("인서트파일---------------", imageVO);
		memoDao.insert(imageVO);
		return null;
	}

}
