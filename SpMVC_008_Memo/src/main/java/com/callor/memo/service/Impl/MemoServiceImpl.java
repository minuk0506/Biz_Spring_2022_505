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
		File dir = new File(upLoadFolder);
		if (!dir.exists()) {
			dir.mkdirs();
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
	public MemoVO findById(String id) {
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
	public int delete(String id) {
		// TODO Auto-generated method stub
		return memoDao.delete(id);
	}

	@Override
	public String insertFile(MemoVO memoVO, MultipartFile file){
		// TODO Auto-generated method stub

		try {
			String fileName = memoService.upFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemoVO imageVO = MemoVO.builder().m_image(file.getOriginalFilename()).build();

		memoDao.insert(imageVO);
		return null;
	}

}
