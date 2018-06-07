package iot.e1m4.com.greenright;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import info.addon.SessionManager;
import info.app.AppConfig;
import info.app.AppController;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentPointFragment extends Fragment {


    Button mPointSaveBtn;
    Button mMarketBtn;
    ListView mListView=null;
    ListViewAdapter mAdapter=null;
    TextView mCurrPoint;
    SessionManager sessionManager;
    public CurrentPointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_current_point, container, false);

        sessionManager = new SessionManager(getActivity());

        mCurrPoint = layout.findViewById(R.id.currPoint);
        getTotalPoint(sessionManager.getUserId());

        //포인트 사용 내역 리스트
        mListView=layout.findViewById(R.id.pointUseList);
        mAdapter=new ListViewAdapter(getActivity());
        mListView.setAdapter(mAdapter);

        mAdapter.addItem("그린 마켓","2000P","2018-06-07");
        mAdapter.addItem("한국 민속촌","1000P","2018-05-31");
        mAdapter.addItem("그린 마켓","3500P","2018-05-23");
        mAdapter.addItem("그린 마켓","2000P","2018-05-14");

        //버튼 이동
        mPointSaveBtn=layout.findViewById(R.id.pointSaveBtn);
        mPointSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contentContainer,new PointFragment()).commit();
            }
        });

        mMarketBtn=layout.findViewById(R.id.shopBtn);
        mMarketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contentContainer, new MarketFragment()).commit();
            }
        });
        return layout;
    }

    private class ViewHolder{
        public TextView mUseTitle;
        public TextView mUsePoint;
        public  TextView mUseDay;
    }

    public class ListViewAdapter extends BaseAdapter{

        private Context mContext=null;
        private ArrayList<UsePoint> mListData=new ArrayList<UsePoint>();

        public ListViewAdapter(Context mContext){
            super();
            this.mContext=mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int i) {
            return mListData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;

            if(view==null){
                holder=new ViewHolder();
                LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.pointuselist, null);

                holder.mUsePoint=view.findViewById(R.id.usePoint);
                holder.mUseTitle=view.findViewById(R.id.useTitle);
                holder.mUseDay=view.findViewById(R.id.useDay);

                view.setTag(holder);
            }else{
                holder= (ViewHolder) view.getTag();
            }

            UsePoint mData=mListData.get(i);

            holder.mUseTitle.setText(mData.getUseTitle());
            holder.mUsePoint.setText(mData.getUsePoint());
            holder.mUseDay.setText(mData.getUseDay());
            return view;
        }
        public void addItem(String mUseTitle,String mUsePoint, String mUseDay){
            UsePoint addInfo = null;
            addInfo = new UsePoint();

            addInfo.setUseTitle(mUseTitle);
            addInfo.setUsePoint(mUsePoint);
            addInfo.setUseDay(mUseDay);
            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }


        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }
    }
    private void getTotalPoint(final String userId) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.TOTAL_POINT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response ==null || response.equals("")) response = "0";
                        mCurrPoint.setText("P " + response);
                        return;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("userId", userId);
                return params;
            }
        };

        AppController.getInstance().
                addToRequestQueue(stringRequest);
    }


}
