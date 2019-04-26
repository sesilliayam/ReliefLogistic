package com.delisar.relo.Category;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    //array list kategori
    private ArrayList<Category> listCategory;

    //konstruktor CategoryAdapter
    public CategoryAdapter (ArrayList<Category> listCategory){
        this.listCategory = listCategory;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate( R.layout.list_item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.txtTitleCategory.setText(listCategory.get(position).getTitle());
//        holder.txtInfoCategory.setText(listCategory.get(position).getInfo ());
    }

    @Override
    public int getItemCount() {
        return (listCategory != null) ? listCategory.size() : 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitleCategory, txtInfoCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            txtTitleCategory = (TextView) itemView.findViewById(R.id.txt_titleCategory);
//            txtInfoCategory = (TextView) itemView.findViewById(R.id.txt_infoCategory);
        }
    }

}
