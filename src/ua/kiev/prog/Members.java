package ua.kiev.prog;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andzhel on 02.02.2016.
 */
@XmlRootElement(name = "members")
public class Members {
    private static Members membersList = new Members();


    @XmlElement(name="member")
    private final List<Member> members = new ArrayList<>();

    private Members(){}

    public synchronized void add(Member member){members.add(member);}

    public static Members getInstance(){return membersList;}

    public static void setInstance(Members members){
        membersList = members;
    }

    public List<Member> getMembers(){return members;}



    @Override
    public String toString() {
        return Arrays.deepToString(members.toArray());
    }

    public Member findByName(String login){
        for (Member member:members) {
            if (login.equals(member.getLogin())) return member;
        }
        return null;
    }

    public String toJSON(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(membersList.members.toArray());
    }


}
