package com.example.lenovo.bbqu.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.activity.NewPostActivity;
import com.example.lenovo.bbqu.activity.PostDetailActivity;
import com.example.lenovo.bbqu.model.postView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/6/10.
 */
public class fragment2  extends Fragment {

    ListView postListView;
    Button newp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment2,container,false);
        postListView=(ListView)view.findViewById(R.id.post_listView);
        final ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        newp=(Button)view.findViewById(R.id.button);
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        HashMap<String, Object> map4 = new HashMap<String, Object>();

        map1.put("postName", "快递帮取                                                               ");
        map1.put("mainPost", "    求助 ，求助，有个快件在派物流，需要16号楼的兄弟帮忙，有16号楼的兄弟在派物流附近吗？  帮个忙呗，  ");
        map1.put("user", "黄坚");

        map2.put("postName", "快递帮取                                                               ");
        map2.put("mainPost", "有10号楼的同学在派物流附近吗？ 有个快递需要帮忙代取下，有的联系我，谢谢呀   ");
        map2.put("user", "邹杭");

        map3.put("postName", "快递丢失                                                               ");
        map3.put("mainPost", "   求助呀，本人有个快递呗哪位同学误领了，是双球鞋，顺丰的快递，快递取货码是32001，误领的朋友请联系我，   ");
        map3.put("user", "张凌霄");

        map4.put("postName", "好消息，放假发件便宜了                                                               ");
        map4.put("mainPost", "   临近放暑假了，很多同学都会寄东西回家，三期派物流现在有活动，每个同学都有一次半价寄送东西的机会哟，不要错过，有需要的去问问吧  ");
        map4.put("user", "王亚栋");

        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        final MyAdapter adapter = new MyAdapter(view.getContext(), data, R.layout.list_post,
                new String[]{ "postName", "mainPost", "user"}, new int[]{ R.id.postName, R.id.mainPost, R.id.user});
        postListView.setAdapter(adapter);

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                postView postv = new postView();
                //postView
                HashMap<String, Object> item = (HashMap<String, Object>) adapter.getItem(position);
                postv.setPostName(String.valueOf(item.get("postName")));
                postv.setMainPost(String.valueOf(item.get("mainPost")));
                postv.setUser(String.valueOf(item.get("user")));
                Intent intent = new Intent(view.getContext(), PostDetailActivity.class);
                intent.putExtra("intent_object", postv);
                startActivity(intent);
            }
        });
        newp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),NewPostActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    class MyAdapter extends SimpleAdapter {
        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            return view;
        }
    }
}
