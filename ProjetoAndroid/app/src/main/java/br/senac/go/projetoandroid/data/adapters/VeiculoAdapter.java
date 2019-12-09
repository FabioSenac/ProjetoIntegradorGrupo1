package br.senac.go.projetoandroid.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.projetoandroid.R;
import br.senac.go.projetoandroid.data.model.Veiculos;

public class VeiculoAdapter extends RecyclerView.Adapter<VeiculoAdapter.ViewHolder> {
    private final List<Veiculos> veiculoList;
    private final LayoutInflater layoutInflater;

    public VeiculoAdapter(List<Veiculos> veiculoList, LayoutInflater layoutInflater) {
        this.veiculoList = veiculoList;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public VeiculoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.activity_adicionar_veiculos_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VeiculoAdapter.ViewHolder holder, int position) {
        holder.bind(veiculoList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return veiculoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(Veiculos veiculos, int position) {
            textView.setText(veiculos.getId() + " " + veiculos.getPlaca() + " " + veiculos.getTipo());

        }
    }
}
