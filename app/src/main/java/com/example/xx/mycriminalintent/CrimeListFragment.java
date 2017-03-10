package com.example.xx.mycriminalintent;

import android.app.Fragment;
import android.content.Context;
import android.database.DataSetObserver;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by XX on 2017/3/10.
 */

public class CrimeListFragment extends Fragment {
    private ListView mCrimeListView;

    private class ListItemHolder implements View.OnClickListener
    {
        private Crime mCrime;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private  CheckBox mSolvedCheckBox;

        public ListItemHolder(Crime crime,View view) {
            super();

            mCrime=crime;
            mTitleTextView=(TextView)view.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView=(TextView)view.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox=(CheckBox)view.findViewById(R.id.list_item_crime_solved_checkbox);
        }

        public void bindContent()
        {
            mTitleTextView.setText(mCrime.getTitle());
            final CharSequence dateString= DateFormat.format("E,MMM dd,yyyy",mCrime.getDate());
            mDateTextView.setText(dateString);
            mSolvedCheckBox.setChecked(mCrime.isSolved());
            /*mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    mCrime.setSolved(b);
                }
            });*/
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),mCrime.getTitle()+" clicked!",Toast.LENGTH_SHORT).show();
        }
    }

    private class CrimeAdaptor extends BaseAdapter
    {
        private List<Crime> mCrimes;
        private LayoutInflater mLayoutInflater;

        public CrimeAdaptor(Context context) {
            super();

            mLayoutInflater=LayoutInflater.from(context);
            mCrimes=CrimeLab.get(getActivity()).getCrimes();
        }

        @Override
        public int getCount() {
            return mCrimes.size();
        }

        @Override
        public Object getItem(int i) {
            return mCrimes.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null)
                view=mLayoutInflater.inflate(R.layout.list_item_crime,viewGroup,false);

            ListItemHolder holder=new ListItemHolder(mCrimes.get(i),view);
            holder.bindContent();
            view.setOnClickListener(holder);

            return view;
            //return null;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_crime_list,container,false);
        mCrimeListView=(ListView) view.findViewById(R.id.crime_list_view);

        mCrimeListView.setAdapter(new CrimeAdaptor(getActivity()));

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
