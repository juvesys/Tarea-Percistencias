package mx.com.mayernet.miscmascotas.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.mayernet.miscmascotas.DetalleMascota;
import mx.com.mayernet.miscmascotas.db.ConstructorMascotas;
import mx.com.mayernet.miscmascotas.pojo.Mascota;
import mx.com.mayernet.miscmascotas.R;

/**
 * Created by fmayer on 13/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRateMascota())+ " Likes");


        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("NombreMascota",mascota.getNombreMascota());
                intent.putExtra("RateMascota",mascota.getRateMascota());
                activity.startActivity(intent);
            }
        });

        mascotaViewHolder.btnBone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "rate " + mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRate.setText(constructorMascotas.obtenerLikesMascotas(mascota) + " " + "Likes");


                constructorMascotas.eliminaLaMascotaTop5(constructorMascotas.ObtieneLaMascotaTop5Eliminar(mascota));
                constructorMascotas.GuardaLaTop5Mascota(mascota);
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    public static class  MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRate;
        public ImageView btnBone;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRate = (TextView) itemView.findViewById(R.id.tvRate);
            btnBone = (ImageView) itemView.findViewById(R.id.btnBone);
        }
    }
}
