package controller;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemesolaire.R;

import java.util.List;

import model.Planete;

public class MyPlaneteAdapter extends RecyclerView.Adapter<MyPlaneteAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    List<Planete> planetes;
    private OnItemClickListener listener;

    public MyPlaneteAdapter(List<Planete> planetes ) {
        this.planetes = planetes;
    }

    public void setOnItemClickListener(OnItemClickListener l){
        this.listener = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.planete, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.display(planetes.get(position));
        holder.setOnItemClickListener(this.listener);
    }

    @Override
    public int getItemCount() {
        return planetes.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView namePlanet;
        private TextView distPlanet;
        private ImageView imagePlanet;
        private MyPlaneteAdapter.OnItemClickListener listener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namePlanet = itemView.findViewById(R.id.nomPlanet);
            distPlanet = itemView.findViewById(R.id.distancePlanet);
            imagePlanet = itemView.findViewById(R.id.imgPlanet);
            itemView.setOnClickListener(this);
        }

        void display (Planete planete){
            namePlanet.setText(planete.getNom());
            distPlanet.setText(String.valueOf(planete.getDistance()));
            imagePlanet.setImageResource(planete.getImage());

        }


        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(getAdapterPosition());
            }
        }
    }
}

