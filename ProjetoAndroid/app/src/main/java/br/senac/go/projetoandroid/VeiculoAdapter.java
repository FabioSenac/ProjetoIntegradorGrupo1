package br.senac.go.projetoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.projetoandroid.data.model.Veiculos;

public class VeiculoAdapter extends RecyclerView.Adapter<VeiculoAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Veiculos> veiculoList;

    public VeiculoAdapter(Context context, List<Veiculos> veiculoListList) {
        this.inflater = LayoutInflater.from(context);
        this.veiculoList = veiculoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_veiculo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(veiculoList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return veiculoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView descricaoTV = itemView.findViewById(R.id.tv_descricao);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Veiculos veiculos, int position) {
            descricaoTV.setText(veiculos.getPlaca());
        }
    }
}
