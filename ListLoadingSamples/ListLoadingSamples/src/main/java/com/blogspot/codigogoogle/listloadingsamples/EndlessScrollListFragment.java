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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 *
 * @author netomarin
 */
public class EndlessScrollListFragment extends ListFragment implements EndlessScrollListener.OnLoadMoreListener {

    private ArrayAdapter<String> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, generateMoreListItems(30));
        setListAdapter(adapter);
        getListView().setOnScrollListener(new EndlessScrollListener(this));
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount) {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                //Simulating delay to get more items from an API.
                try {
                    Thread.sleep(1000);
                    return generateMoreListItems(10);
                } catch (InterruptedException e) {
                }
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<String> items) {
                for (String item : items) {
                    adapter.add(item);
                }
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private ArrayList<String> generateMoreListItems(int numberToGenerate) {
        int startNumber = adapter == null ? 1 : adapter.getCount() + 1;
        ArrayList<String> items = new ArrayList<String>();

        for (int i = 0; i < numberToGenerate; i++, startNumber++) {
            items.add("More items - " + startNumber);
        }

        return items;
    }
}