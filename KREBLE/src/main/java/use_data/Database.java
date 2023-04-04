package use_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
	Connection con = null;
	Statement stm = null;
	public void conn() throws Exception {//연결 메소드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kreble?useUnicode=true&characterEncoding=utf8","root","knight");
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
		} catch (ClassNotFoundException e) {
			
		}
	}
	public void diconn() {//연결 해제 메소드
		try{
			stm.close();
			con.close();
		}catch(Exception ignored){
			
		}
	}
	
	
	
	public String login_data(String id, String pw) throws Exception {
		String login;
		try{
			conn();
			ResultSet rs= stm.executeQuery("select user_id from user where user_id='"+id+"' AND user_pass='"+pw+"';");
			if(rs.next()){
				login="true";
			}
			else {
				login="false";
			}
		}finally {
			diconn();
		}
		return login;
	}
	
	public ArrayList<String> join_member_idcheck() throws Exception {
		ArrayList<String> idList = new ArrayList<String>();
		try{
			conn();
			ResultSet rs= stm.executeQuery("select user_id from user;");
			while(rs.next()){
				idList.add(rs.getString("user_id"));
			}
		}finally {
			diconn();
		}
		return idList;
	}
	
	public void join_member_succass(UserData ud) throws Exception {
		try{
			conn();
			String command = String.format("insert into user values('"+ud.getId()+"','임시닉네임1234' ,'"+ud.getName()+"','"+ud.getPw()+"','"+ud.getPh()+"','"+ud.getEmail()+"','"+ud.getAddress()+"','"+ud.getGender()+"',now(), now(), default);");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	
	public ArrayList<CommunityData> commu_all() throws Exception { //커뮤니티 호출 메소드
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from community order by commu_no desc;");
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public ArrayList<CommunityData> commu_cate(String cate) throws Exception { //커뮤니티 카테고리별 호출 메소드
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from community where category='"+cate+"' order by commu_no desc;");
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public CommunityData commu_one(int comu_no) throws Exception { //커뮤니티 페이지1개 호출 메소드
		conn();
		CommunityData cdb= new CommunityData();
		try{
			ResultSet rs= stm.executeQuery("select * from community where commu_no="+comu_no+";");
			if(rs.next()) {
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
			}
		}finally {
			diconn();
		}
		return cdb;
	}
	
	public ArrayList<CommunityData> commu_search(String select, String text) throws Exception { //커뮤니티 검색 메소드
		conn();
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		try{
			StringBuilder commandBuilder = new StringBuilder();
			commandBuilder.append("select * from community");
			if(select.equals("search_title")) {
				commandBuilder.append(" where commu_title like '%"+text+"%'");
			}
			else if(select.equals("search_title_write")) {
				commandBuilder.append(" where commu_title like '%"+text+"%' or commu_write like '%"+text+"%'");
			}
			else if(select.equals("search_name")) {
				commandBuilder.append(" where user_id='"+text+"'");
			}
			commandBuilder.append(" order by commu_no desc;");
			String aa = commandBuilder.toString();
			ResultSet rs = stm.executeQuery(aa);
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public int commu_last() throws Exception { //커뮤니티 페이지1개 호출 메소드
		conn();
		int last_no =0;
		try{
			ResultSet rs= stm.executeQuery("select max(commu_no) from community;");
			if(rs.next()) {
				last_no=rs.getInt("max(commu_no)");
			}
		}finally {
			diconn();
		}
		return last_no;
	}
	
	public void commu_write(CommunityData cmd) throws Exception { //커뮤니티 글 작성
		try{
			conn();
			String command = String.format("insert into community values('"+cmd.getId()+"',default,'"+cmd.getCategory()+"','"+cmd.getComu_title()+"','"+cmd.getComu_write()+"','a',0,now());");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	public void commu_change(CommunityData cmd) throws Exception { //커뮤니티 글 수정
		try{
			conn();
			String command = String.format("update community set category:='%s',commu_title:='%s',commu_write:='%s' where commu_no=%s AND user_id='%s'",cmd.getCategory(),cmd.getComu_title(),cmd.getComu_write(),cmd.getComu_num(),cmd.getId());
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	public void commu_delete(String no, String id) throws Exception { //커뮤니티 글 삭제
		try{
			conn();
			String command = String.format("delete from community where commu_no=%s and user_id='%s';",no,id);
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}

	//  게시판 로드
	  public ArrayList<Shop_reform_db> shop_board() throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from shop_reform;");
			    while(rs.next()) {
			    	Shop_reform_db ob = new Shop_reform_db();
			    	ob.setRenum(rs.getInt("shop_renum"));		    	
			    	ob.setRecata(rs.getString("shop_recata"));		    	
			    	ob.setRetitle(rs.getString("shop_retitle"));		    	
			    	ob.setReid(rs.getString("shop_reid"));		    	
			    	ob.setRetrade(rs.getString("shop_retrade"));		    	
			    	ob.setRedate(rs.getString("shop_redate"));		    	
			    	board.add(ob);
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  
		  return board;
	  }
//	  게시판 서치
	  public ArrayList<Shop_reform_db> shop_board_sc(String re_trade, String re_title) throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  if(re_title!="") {
		  re_title.trim().toLowerCase();
		  }
		  try{
			  conn();
			    if(con == null){
				      throw new Exception("데이터베이스에 연결할 수 없습니다.");
				    }
				    stm = con.createStatement();
				    
				    StringBuilder commandBuilder = new StringBuilder();
				    commandBuilder.append("select * from shop_reform");
				    if(re_trade != "" || re_title != "") {
				        commandBuilder.append(" where ");
				    }
				    if(re_trade!="") {
				    	commandBuilder.append("shop_retrade='"+re_trade+"'");
				    }
				    
				    if(re_trade!="" && re_title!="") {
				    	commandBuilder.append("and shop_retitle like '%"+re_title+"%'");
				    }else if(re_trade=="" && re_title!="") {
				    	commandBuilder.append("shop_retitle like '%"+re_title+"%'");
				    }
				    commandBuilder.append(";");
				    
				    String aa = commandBuilder.toString();
				    ResultSet rs = stm.executeQuery(aa);
				    while(rs.next()) {
				    	Shop_reform_db ob = new Shop_reform_db();
				    	ob.setRenum(rs.getInt("shop_renum"));		    	
				    	ob.setRecata(rs.getString("shop_recata"));		    	
				    	ob.setRetitle(rs.getString("shop_retitle"));		    	
				    	ob.setReid(rs.getString("shop_reid"));		    	
				    	ob.setRetrade(rs.getString("shop_retrade"));		    	
				    	ob.setRedate(rs.getString("shop_redate"));		    	
				    	board.add(ob);
				    }
			    while(rs.next()) {
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  return board;
	  }
	  // 카테고리 서치
	  public ArrayList<Shop_reform_db> shop_board_casc(String cata) throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  try{
			  conn();
			    if(con == null){
				      throw new Exception("데이터베이스에 연결할 수 없습니다.");
				    }
				    stm = con.createStatement();
				    ResultSet rs = stm.executeQuery("select * from shop_reform where shop_recata = '" + cata + "';");
				    if(rs.next()) {
				    	Shop_reform_db ob = new Shop_reform_db();
				    	ob.setRenum(rs.getInt("shop_renum"));		    	
				    	ob.setRecata(rs.getString("shop_recata"));		    	
				    	ob.setRetitle(rs.getString("shop_retitle"));		    	
				    	ob.setReid(rs.getString("shop_reid"));		    	
				    	ob.setRetrade(rs.getString("shop_retrade"));		    	
				    	ob.setRedate(rs.getString("shop_redate"));		    	
				    	board.add(ob);
				    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  return board;
	  }
	  
	  //  게시글 로드
	  public Shop_reform_db shop_board_1(String aa) throws Exception{
		  Shop_reform_db board = new Shop_reform_db();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from shop_reform where shop_renum = " + aa + ";");
			    if(rs.next()) {
			    board.setRequnt(rs.getInt("shop_requnt"));
			    board.setRecata(rs.getString("shop_recata"));
			    board.setRetitle(rs.getString("shop_retitle"));
			    board.setReid(rs.getString("shop_reid"));
			    board.setRetrade(rs.getString("shop_retrade"));
			    board.setRedate(rs.getString("shop_redate"));
			    board.setRetext(rs.getString("shop_retext"));
			    }
		  		}catch(Exception ignored){
			  }finally{
				  diconn();
			  }
		  
		  return board;
	  }

	//입력메소드
	  public void board_input(Shop_reform_db aal) throws Exception{
	  	  String cata = aal.getRecata();
	  	  String title = aal.getRetitle();
	  	  String id = aal.getReid();
	  	  String trade = aal.getRetrade(); 
	  	  int qunt = aal.getRequnt();
	  	  String text = aal.getRetext();
	  	  String date = aal.getRedate();
	  	  try{
	  		  conn();
	  		if(con == null){
	  			throw new Exception("데이터베이스에 연결할 수 없습니다.");
	  		}
	  		stm=con.createStatement();
	  	    String command = String.format("insert into shop_reform values(default,'%s','%s','%s','%s',%s,%s,'%s')",cata,title,id,trade,qunt,date,text);
	  		int rowNum = stm.executeUpdate(command);
	  		if(rowNum<1){
	  			throw new Exception("데이터를 DB에 입력할 수 없습니다.");
	  		}
	  	    

			}catch(Exception ignored){
	  	  }finally{
	  		  diconn();
	  	  }
	  }
	  
	  
	  //수정메소드
	  public void board_mody(Shop_reform_db aal) throws Exception{
		  try{
			  conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
		    String command = String.format("update shop_reform set shop_recata = '"+aal.getRecata()+"',shop_retitle= '"+aal.getRetitle()+"',shop_retrade='"+aal.getRetrade()+"',shop_requnt = "+aal.requnt+",shop_retext = '"+aal.getRetitle()+"' where shop_renum="+aal.getRenum()+";");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
			}catch(Exception ignored){
		  }finally{
			  diconn();
		  }
	}
	
	
	//삭제메소드
	public void dbdelete(String renum) throws Exception {
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			String command = String.format("delete from shop_reform where shop_renum = " + renum + ";");
			int comm = stm.executeUpdate(command);
			if(comm<1) {
				throw new Exception("데이터를 삭제할 수 없습니다.");
			}

		}catch(Exception ignored){
		}finally {
			diconn();
		}
	}
	
	//대여/예약(최승혁) 리뷰 게시판 메소드들
	public ArrayList<ReviewData> db_review_select() throws Exception {
		ArrayList<ReviewData> reviewList = new ArrayList<ReviewData>();
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select*from rent_review order by num desc;");
			while(rs.next()){
				ReviewData ob=new ReviewData();
				ob.setNum(rs.getInt("num"));
				ob.setId(rs.getString("id"));
				ob.setTitle(rs.getString("title"));
				ob.setPut(rs.getString("put"));
				ob.setGood(rs.getInt("good"));
				ob.setView(rs.getInt("view"));
				ob.setDate(rs.getString("date"));
				ob.setRating(rs.getInt("rating"));
				reviewList.add(ob);
			}
		}finally {
			diconn();
		}
		return reviewList;
	}
	
	public ReviewData review_list_check(String num) throws Exception {
		ReviewData list=new ReviewData();
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select * from rent_review where num = '"+ num +"';");
			if(rs.next()){
				list.setNum(rs.getInt("num"));
				list.setId(rs.getString("id"));
				list.setTitle(rs.getString("title"));
				list.setPut(rs.getString("put"));
				list.setGood(rs.getInt("good"));
				list.setView(rs.getInt("view"));
				list.setDate(rs.getString("date"));
				list.setRating(rs.getInt("rating"));
			}
		}finally {
			diconn();
		}
		return list;
	}
	
	//////리뷰 게시판 인서트 메소드
	public void db_review_insert(ReviewData review_insr) throws Exception  {
		  //insr에 있는 자료가 여러개 이므로 객체를 생성해서 그안에 자료를 담아놓고 객체를 리턴 받은것.
			String idin=review_insr.getId();
			String titlein=review_insr.getTitle();
			String writein=review_insr.getPut();
			Integer ratingin=review_insr.getRating();
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("insert into rent_review values (default,'%s','%s','%s',default,default,now(),%s)",idin,titlein,writein,ratingin);
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}
	public void db_review_update(ReviewData review_upda) throws Exception  {
			Integer numin=review_upda.getNum();
			String titlein=review_upda.getTitle();
			String putin=review_upda.getPut();
			Integer ratingin=review_upda.getRating();
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("update rent_review set title:='%s',put:='%s',rating:=%s where num=%s",titlein,putin,ratingin,numin);
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}
	
	public void  db_review_delete(String num) throws Exception  {
	
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("delete from rent_review where num = '"+ num +"';");
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}

	public void db_review_count(String num) throws Exception  {
		
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			String command = String.format("update rent_review set view:= view + 1 where num = '"+ num +"';");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
	  }finally{
		  diconn();
	  }
	  
}
	public void db_good_count(String num) throws Exception  {
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("update rent_review set good:= good + 1 where num = '"+ num +"';");
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
	  
	}




}
