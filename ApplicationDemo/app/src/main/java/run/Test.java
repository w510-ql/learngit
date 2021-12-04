package run;

import java.sql.SQLException;
import java.util.List;

import DB.dao.dao.AnsDao;
import DB.dao.dao.BoxDao;
import DB.dao.dao.BoxSharedDao;
import DB.dao.dao.QuesDao;
import DB.dao.dao.UserDao;
import DB.dao.model.Ans;
import DB.dao.model.Box;
import DB.dao.model.BoxShared;
import DB.dao.model.Ques;
import DB.dao.model.User;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Connection con = DBUtil.getConnection();
//        PreparedStatement ps = con.prepareStatement("set title UTF8");
//        ps.execute();

        //User & UserDao
        User user = new User("965480310","再来一个榴莲千层","www123");
        UserDao userdao = new UserDao();
        //System.out.println(userdao.add(user));
//        try {
//            userdao.update(DBUtil.getConnection(),user,"再来一打榴莲披萨");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        User u = userdao.select("1191015413");
//        System.out.println(u.toString());

        Box box = new Box(user.getAccount(),"有啥尽管问，大大方方，爷给你答4");
        BoxDao boxDao = new BoxDao();
//        boxDao.add(box);
        box.setNo("5");
//        try {
//            boxDao.update(DBUtil.getConnection(), box,"知无不言言无不尽");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        Box b = boxDao.select(box.getNo());
//        System.out.println(b.toString());
//        System.out.println(b.getTitle());

        BoxShared bs1 = new BoxShared("4","1191015413","927062430");
        BoxShared bs2 = new BoxShared("5","965480310","927062430");
        BoxShared bs3 = new BoxShared("4","1196054559","927062430");
        BoxSharedDao bsDao = new BoxSharedDao();
//        bsDao.add(bs1);
//        bsDao.add(bs2);
//        bsDao.add(bs3);
        List<BoxShared> list = bsDao.selectFromReciver("927062430");
        for(int i=0;i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }
//
//        CollectBox cb = new CollectBox("1191015413","4");
//        CollectBox cb2 = new CollectBox("1191015413","5");
//        CollectBoxDao cbDao = new CollectBoxDao();
//        cbDao.add(cb);
//        cbDao.add(cb2);
//        List<Box> cblist = cbDao.selectFromOwner("1191015413");
//        for(int i=0;i<cblist.size();i++){
//            System.out.println(cblist.get(i).toString());
//        }

//        cbDao.delete(cb2);
//        System.out.println("-- test delete --");
//        List<Box> cblist2 = cbDao.selectFromOwner("1191015413");
//        for(int i=0;i<cblist2.size();i++){
//            System.out.println(cblist2.get(i).toString());
//        }
        Ques ques = new Ques(box.getNo(),"大佬，作业写完了吗？");
        Ques ques2 = new Ques(box.getNo(),"未来啥规划？");
        Ques ques3 = new Ques(box.getNo(),"最喜欢听啥类型的歌？");
        Ques ques4 = new Ques(box.getNo(),"最近一周有说明特别happy的事情嘛");
        QuesDao qDao = new QuesDao();
//        qDao.addWithoutName(ques);
//        qDao.addWithoutName(ques2);
//        qDao.addWithoutName(ques3);
//        qDao.addWithoutName(ques4);


        List<Ques> quesBoxList = qDao.selectFromBoxNo(box.getNo());
        for(int i=0;i<quesBoxList.size();i++){
            System.out.println(quesBoxList.get(i).toString());
        }

//        List<Ques> quesBoxWithoutAnsList = qDao.selectFromBoxNoWithoutAns(box.getNo());
//        for(int i=0;i<quesBoxWithoutAnsList.size();i++){
//            System.out.println(quesBoxWithoutAnsList.get(i).toString());
//        }
//        ques.setNo("14");
//        Ans ans = new Ans(ques.getNo(),"作业是啥？哈哈哈");
        AnsDao ansDao = new AnsDao();
//        ansDao.add(ans);
        ques2.setNo("11");
        Ans ans2 = new Ans(ques2.getNo(),"读研，搞技术");
        ansDao.add(ans2);




    }

}
