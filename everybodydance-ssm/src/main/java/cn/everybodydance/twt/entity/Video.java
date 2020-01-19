package cn.everybodydance.twt.entity;

/**
 * java bean video 舞蹈视频实体类
 * 
 * @author tanwentao
 *
 */
public class Video {
	// 视频的路径
	private String path;
	// 视频的标题（主键）
	private String title;
	// 视频分组(女神班/女王班/艺能班/天赋班)
	private String group;
	// 视频排序
	private int index;

	/**
	 * getter and setter
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return "Video [path=" + path + ", title=" + title + ", group=" + group + ", index=" + index + "]";
	}

}
