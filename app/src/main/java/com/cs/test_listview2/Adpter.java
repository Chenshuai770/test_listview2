package com.cs.test_listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by chenshuai on 2017/1/19.
 * 双层fori循环执行顺序
 * 非要从顺序上将，那就是先外层循环，但是顺序是这样的，
 外循环执行一次，内循环就要完整的执行一遍，然后再判断外循环是否成立。。。。。。
 */

public class Adpter extends BaseAdapter {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
    private ArrayList<String> data = new ArrayList<String>();
    private TreeSet<Integer> title=new TreeSet<>();
    private LayoutInflater inflater;
    /**
     *
     set集合中的数据没有顺序，且如果add两个一样的对象或基本类型的数据，set集合里也是只有一个，
     即set集合中的数据都是独一无二的；不能使用加强的for循环；
     list中的数据是有顺序的，可以加入多个一样的对象和基本类型的数据，可使用加强的for循环；
     HashSet依赖于HashMap，它实际上是通过HashMap实现的。HashSet中的元素是无序的。
     TreeSet依赖于TreeMap，它实际上是通过TreeMap实现的。TreeSet中的元素是有序的。
     */
    private HashSet<Integer> table = new HashSet<Integer>();


    public Adpter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    /**
     * 加入数据
     * @param item
     */
    public void addItem(String item){
        data.add(item);
    }
//问题一
   public void addSeparatorItem(String item){
       data.add(item);
       table.add(data.size() - 1);
   }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //问题三
    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }
    //问题二
    @Override
    public int getItemViewType(int position) {
        return table.contains(position)?TYPE_SEPARATOR:TYPE_ITEM;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        int type = getItemViewType(i);
        if (convertView == null) {
            holder=new ViewHolder();
            switch (type){
                case TYPE_ITEM:
                    convertView = inflater.inflate(R.layout.item1, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.item1);
                    break;
                case TYPE_SEPARATOR:
                    convertView = inflater.inflate(R.layout.item2, null);
                    holder.textView = (TextView) convertView
                            .findViewById(R.id.item2);
                    break;
            }
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(data.get(i));
        return convertView;
    }
    public static class ViewHolder {
        public TextView textView;
    }
}
