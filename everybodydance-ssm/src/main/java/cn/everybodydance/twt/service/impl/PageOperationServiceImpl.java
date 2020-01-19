package cn.everybodydance.twt.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.everybodydance.twt.dao.HandleVideoDao;
import cn.everybodydance.twt.entity.Video;
import cn.everybodydance.twt.service.PageOperationService;

/**
 * 页面操作实现类
 * 
 * @author tanwentao
 *
 */
@Service
public class PageOperationServiceImpl implements PageOperationService {
	/**
	 * 注入数据库操作层
	 */
	@Autowired
	private HandleVideoDao handleVideoDaoImpl;
	/**
	 * 日之类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Map<String, Object> selectIdByTitle(String title, String group) {
		Map<String, Object> result = new HashMap();
		try {
			int index = handleVideoDaoImpl.selectIdByTitle(title, group);
			logger.info("Dao层:index:{}", index);
			result.put("success", "true");
			result.put("index", index);
		} catch (Exception e) {
			logger.error("Dao层:查询视频排序index异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> updateVideo(String newtitle, int index, String group) {
		Map<String, Object> result = new HashMap();
		try {
			handleVideoDaoImpl.updateVideo(newtitle, index, group);
			logger.info("Dao层:名字更新为:{}", newtitle);
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("Dao层名字更新异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> insertVideo(Video video) {
		Map<String, Object> result = new HashMap();
		try {
			handleVideoDaoImpl.insertVideo(video);
			logger.info("Dao层:新增视频数据：{}", video.toString());
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("Dao层:新增视频数据异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> deleteVideo(int index, String group) {
		Map<String, Object> result = new HashMap();
		try {
			handleVideoDaoImpl.deleteVideo(index, group);
			logger.info("Dao层:删除视频数据成功!");
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("Dao层:删除视频数据异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public String selectPathByIndexAndGroup(int index, String group) {
		String path="";
		try {
			 path=handleVideoDaoImpl.selectPathByIndexAndGroup(index, group);		
			logger.info("Dao层:需要删除视频的路径为：{}",path);
		}catch(Exception e) {
			logger.error("Dao层:查询需要删除的视频路径失败！{}",e.getMessage());
		}
		return path;
	}

}
