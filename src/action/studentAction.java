package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.CheckHelper;
import utils.PicFace;
import utils.PictureHelper;
import utils.StudentAbsenceTimerTask;
import utils.Values;
import db.entity.Course;
import db.entity.CourseInfo;
import db.entity.StudentInfo;
import db.util.DBHelper;
import pic.entity.FaceEntity;

public class studentAction extends MyActionSupport{	
	String msg="";
	String index="";
	Map session = getSession();
	String sno = (String) session.get("id");//获取学号
	List<CourseInfo> courses = new ArrayList<CourseInfo>();//课程链表，保存当前时间学生的课程信息

	/**
	 * 在返回页面之前，需要从数据库中比对，查找当前要上的课，
	 * 然后把课程信息放到request里传递过去。
	 * 若当前时间有课，那么还要判断老师是否已经上传点名图片，
	 * 若有，则也要放到request里传递到网页端。
	 * 若当前时间段没有课，那么就返回NOCURRENTCLASS，跳转到无课页面。
	 */
	@Override
	public String index(){
		
		if ( !session.get("identity").equals("student") ){
			return ERROR;
		}else{
			List<String> coursesno = DBHelper.getCoursesno("student", sno);
			/*
			 * 0为显示所有课程和信息
			 * 1为显示当前课程信息
			 * -1为这周不属于上课周，放假或者为自习周，无课
			 * 大于1为课程冲突
			 */
			courses = DBHelper.getAllCoursesInfo("student",sno,coursesno,false);
			int count = -1;
			if ( courses != null) 
				count = courses.size();
			session.put("coursesNum", count);//返回当天的课程数
			if ( count == 0 ){//当天无课，返回NOCURRENTCLASS
				courses = DBHelper.getAllCoursesInfo("student",sno,coursesno,true);
				count = courses.size();
				session.put("coursesNum",count);
				session.put("coursesInfo", courses);//传入所有课程编号
				return NOCURRENTCLASS;
			}else if ( count == 1 ){//当天有一节课，返回SUCCESS
				String cno = courses.get(0).getCno();
				session.put("cno", cno);
				session.put("tno", courses.get(0).getTno());
				session.put("coursesInfo", courses);//传入当前课程的类，包含具体信息
				/*
				 * 判断老师是否已经将点名的图片上传，
				 * 若已经上传，则放在session里传过去
				 */
				session.put("picUrl", PictureHelper.getPicUrl(DBHelper.getTnoBySnoCno(sno, cno)));
			}else if ( count > 1){//课程冲突，返回SUCCESS，由界面判断处理
				session.put("coursesInfo", courses);//课程冲突，将所有课传入，便于页面显示
			}else if ( count == -1 ){//当天无课，返回SUCCESS，由界面判断处理
				session.put("coursesInfo", "这周不属于上课周，放假或者为自习周，无课");
			}
			
			return SUCCESS;
		}
	}

	/**
	 * 选择自己的脸，并将信息进行处理和传递
	 * @return
	 */
	public String chooseOneFace(){
		//左上角坐标点的信息
		FaceEntity face=(FaceEntity) session.get("face");
		if(face.getSno()==null||face.getSno()==""){
			@SuppressWarnings("unchecked")
			List<FaceEntity> faceInfo=(List<FaceEntity>) session.get("faces");
			String sno=(String) session.get("id");
			for(int i=0;i<faceInfo.size();i++){
				if(faceInfo.get(i).equals(face)){
					face.setSno(sno);
					PicFace picFace=(PicFace) session.get("picface");
					picFace.setFaceName(face.getcX(), face.getcY(), sno);
				}
			}
			msg="这张脸是你的啦^_^";
			session.put("faces",faceInfo);
			return SUCCESS;
		}
		msg="该脸已被占用=.=";
		return SUCCESS;
	}
	
	
	public String addFace(){
		String tno = (String)session.get("tno");
		if (Values.studentsInfo_for_each_class.get(tno) == null)
			session.put("checkStatus", 0);//0表示不在点名时间
		else session.put("checkStatus", 1);
		
		CheckHelper myCheckHelper = CheckHelper.getCheckHelper();
		if ( myCheckHelper.getCheckFaceList() == null && session.get("facesList") != null)
			myCheckHelper.setCheckFaceList((List<FaceEntity>)session.get("facesList"));
		if ( !index.equals("") ){
			CheckHelper.getCheckHelper().checkIn(new Integer(index), tno);
		}
		return SUCCESS;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
}