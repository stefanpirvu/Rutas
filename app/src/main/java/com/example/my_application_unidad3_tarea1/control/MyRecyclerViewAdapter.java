package com.example.my_application_unidad3_tarea1.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_application_unidad3_tarea1.R;
import com.example.my_application_unidad3_tarea1.model.Ruta;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final List<Ruta> rutas;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private int selectedPosition = RecyclerView.NO_POSITION;
    private RecyclerView recyclerView;

    public MyRecyclerViewAdapter(Context contexto, ArrayList<Ruta> rutas) {
        this.mInflater = LayoutInflater.from(contexto);
        this.rutas = rutas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ruta ruta = rutas.get(position);
        holder.myTextView.setText(ruta.getNombre());
        holder.myImageView.setImageResource(ruta.getImagen());
    }

    @Override
    public int getItemCount() {
        return rutas.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public View getViewByPosition(int position) {
        if (recyclerView == null) return null;
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
        return viewHolder != null ? viewHolder.itemView : null;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public Ruta getItem(int id) {
        return rutas.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView myTextView;
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView1);
            myImageView = itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            itemView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
                selectedPosition = getAdapterPosition();
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            v.showContextMenu();
            return true;
        }
    }
}
