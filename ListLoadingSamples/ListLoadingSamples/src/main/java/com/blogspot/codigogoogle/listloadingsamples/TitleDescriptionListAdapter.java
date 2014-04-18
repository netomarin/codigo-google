/**
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blogspot.codigogoogle.listloadingsamples;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by netomarin on 4/16/14.
 */
public class TitleDescriptionListAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<Map<String, String>> listItems;

    static class ViewHolder  {
        public TextView titleTextView;
        public TextView descTextView;
    }

    public TitleDescriptionListAdapter(Activity context, ArrayList<Map<String, String>> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View listItemView = convertView;

        if(convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            listItemView = inflater.inflate(R.layout.list_item_title_desc, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.titleTextView = (TextView) listItemView.findViewById(R.id.listItemTitle);
            viewHolder.descTextView = (TextView) listItemView.findViewById(R.id.listItemDescription);
            listItemView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) listItemView.getTag();
        Map<String, String> titleDesc = (Map<String, String>) getItem(position);
        holder.titleTextView.setText(titleDesc.get("title"));
        holder.descTextView.setText(titleDesc.get("description"));

        return listItemView;
    }
}