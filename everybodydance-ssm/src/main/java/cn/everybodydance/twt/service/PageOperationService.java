package cn.everybodydance.twt.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.everybodydance.twt.entity.Video;

/**
 * 页面操作服务
 * 
 * @author tanwentao
 *
 */
public interface PageOperationService {
	/**
	 * 根据标题查找视频的排序
	 * 
	 * @param title
	 * @param group
	 * @return
	 */
	public Map<String, Object> selectIdByTitle(String title, String group);

	/**
	 * 根据index修改视频名字
	 * 
	 * @param newtitle 新的视频名字
	 * @param index    视频排列字段
	 * @param group    分组
	 */
	public Map<String, Object> updateVideo(String newtitle, int index, String group);

	/**
	 * 新增视频
	 * 
	 * @param path  保存在服务器本地的路径
	 * @param title 视频标题（主键）
	 * @param group 视频分组（女神组：001 女王祖：002 艺能组：003 天赋组：004）
	 * @param index 视频排列字段
	 * @return
	 */
	public Map<String, Object> insertVideo(Video video);

	/**
	 * 删除视频
	 * 
	 * @param title 视频标题
	 * @param group 分组
	 */
	public Map<String, Object> deleteVideo(int index, String group);

	/**
	 * 根据下标和组名查询视频路径
	 * 
	 * @param index 下标
	 * @param group 分组
	 * @return
	 */
	public String selectPathByIndexAndGroup(int index, String group);
}
