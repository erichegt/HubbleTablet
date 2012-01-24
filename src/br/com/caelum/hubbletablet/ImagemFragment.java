package br.com.caelum.hubbletablet;

import java.io.IOException;
import java.io.InputStream;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagemFragment extends Fragment {

	private String imagem;
	private ImageView imageView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View layoutImagem = inflater.inflate(R.layout.imagem, null);
		imageView = (ImageView) layoutImagem.findViewById(R.id.imageView1);
		this.atualizaImagem();

		return layoutImagem;
	}
	
	private Bitmap carregaImagem() {
		try {
			InputStream is = getActivity().getAssets().open(imagem);
			return BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void atualizaImagem() {
		if (imagem!=null) {
			imageView.setImageBitmap(carregaImagem());
		}
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}