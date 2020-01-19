package cn.everybodydance.twt.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.everybodydance.twt.entity.Video;
import cn.everybodydance.twt.service.PageOperationService;

/**
 * 页面操作控制器
 * 
 * @author tanwentao
 *
 */
@Controller
@RequestMapping("/html/page")
public class PageOperationController {
	/**
	 * 日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 注入页面操作服务
	 */
	@Autowired
	private PageOperationService pageOperationServiceImpl;
	/**
	 * MB换算成BYTE常量 for example ---> 5m =5*MB_2_BYTE
	 */
	private final int MB_2_BYTE = 1048576;

	/**
	 * 文件上传最大容量
	 */
	@Value("${arbd.fileupload.maxuploadSize}")
	private String maxSize4FileUpload;
	/**
	 * 文件上传路径
	 */
	@Value("${arbd.fileupload.filepath}")
	private String filePath;

	/**
	 * 根据标题查询视频排序
	 * 
	 * @param request
	 * @param response
	 * @param title
	 * @param group
	 * @return
	 */
	@RequestMapping(value = "selectIdByTitle", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectIdByTitle(HttpServletRequest request, HttpServletResponse response, String title,
			String group) {
		logger.info("Controller层已转发请求:{}", "/html/page/selectIdByTitle");
		Map<String, Object> result;
		result = pageOperationServiceImpl.selectIdByTitle(title, group);
		return result;
	}

	/**
	 * 修改视频的标题
	 *
	 * @param request
	 * @param response
	 * @param newtitle
	 * @param index
	 * @param group
	 * @return
	 */
	@RequestMapping(value = "updateVideo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateVideo(HttpServletRequest request, HttpServletResponse response, String newtitle,
			int index, String group) {
		logger.info("Controller层已转发请求:{}", "/html/page/updateVideo");
		Map<String, Object> result;
		result = pageOperationServiceImpl.updateVideo(newtitle, index, group);
		return result;
	}

	/**
	 * 插入新的数据
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param title
	 * @param group
	 * @param index
	 * @return
	 */
	@RequestMapping(value = "insertVideo1", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertVideo1(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "files", required = false) MultipartFile multipartFile) {
		logger.info("Controller层已转发请求:{}", "/html/page/insertVideo1");
		Map<String, Object> result = new HashMap<String, Object>();
		int maxSize = Integer.valueOf(maxSize4FileUpload) * MB_2_BYTE;
		String realpath = "";
		String errorMessage = "";
		// 获取文件名
		String name = "";
		if (multipartFile != null) {
			long size = multipartFile.getSize();
			// 文件设置大小
			if (size > maxSize) {
				errorMessage = "文件过大！请重新选择！当前最大文件限制为：" + maxSize4FileUpload + "MB!";
				logger.error(errorMessage);
				result.put("success", "false");
				result.put("errorMessage", errorMessage);
				return result;
			}
			// 直接返回文件的名字
			name = multipartFile.getOriginalFilename();
			// 我这里取得文件后缀
			String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());
			// 文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行了。
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			// 目录不存在就创建
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 保存文件
			try {
				multipartFile.transferTo(new File(file + "/" + fileName + "." + subffix));
			} catch (Exception e) {
				logger.error("文件上传出错:{}", e.getMessage());
				result.put("success", "false");
				result.put("errorMessage", e.getMessage());
				return result;
			}
			realpath = file + "/" + fileName + "." + subffix;
		}
		result.put("success", "true");
		result.put("videopath", realpath);
		return result;
	}

	/**
	 * 插入新的数据
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param title
	 * @param group
	 * @param index
	 * @return
	 */
	@RequestMapping(value = "insertVideo2", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertVideo2(HttpServletRequest request, HttpServletResponse response, String path,
			String title, String group, String index) {
		logger.info("Controller层已转发请求:{}", "/html/page/insertVideo2");
		Map<String, Object> result = new HashMap<String, Object>();
		Video video = new Video();
		video.setGroup(group);
		video.setIndex(Integer.valueOf(index));
		video.setPath(path);
		video.setTitle(title);
		try {
			pageOperationServiceImpl.insertVideo(video);
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("新增视频入库异常:{}", e.getMessage());
			result.put("success", false);
			result.put("errorMessage", "新增视频入库异常:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 删除视频（删除指定库中的数据和远程地址保存的视频）
	 * 
	 * @param request
	 * @param response
	 * @param group
	 * @param index
	 * @return
	 */
	@RequestMapping(value = "deleteVideo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteVideo(HttpServletRequest request, HttpServletResponse response, String group,
			String index) {
		logger.info("Controller层已转发请求:{}", "/html/page/deleteVideo");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String path = pageOperationServiceImpl.selectPathByIndexAndGroup(Integer.valueOf(index), group);
			if (path == "") {
				logger.error("数据库无该条视频记录，记录已经删除！视频是否删除未知！");
				result.put("success", false);
				result.put("errorMessage", "删除视频异常:" + "数据库无该条视频记录，记录已经删除！视频是否删除未知！");
				return result;
			}
			File file = new File(path);
			if (!file.exists()) {
				logger.error("该视频路径不存在！视频资源已被删除！");
			}
			if (!file.isFile()) {
				logger.error("该视频路径非文件!视频资源已被删除！");
			}
			try {
				file.delete();
				logger.info("该路径下视频已成功删除！");
			} catch (Exception e) {
				logger.error("删除指定路径下视频失败！{}",e.getMessage());
				result.put("success", false);
				result.put("errorMessage", "删除指定路径下视频失败！{}" + e.getMessage());
			}
			pageOperationServiceImpl.deleteVideo(Integer.valueOf(index), group);
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("删除数据库中视频数据异常:{}", e.getMessage());
			result.put("success", false);
			result.put("errorMessage", "删除数据库中视频数据异常:" + e.getMessage());
		}
		return result;
	}

}
