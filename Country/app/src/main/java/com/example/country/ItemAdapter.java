package com.example.country;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    Context context;
    private List<Country> countryList;
    public ItemAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }
    public void setData(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Country country = countryList.get(position);
        if(country == null)
            return;
        ((TextView) holder.view.findViewById(R.id.countryname)).setText(country.getCountryName());
//        ((TextView) holder.view.findViewById(R.id.countrycode)).setText(country.getCountryCode() + " - ");
//        ((TextView) holder.view.findViewById(R.id.currencycode)).setText(country.getCurrencyCode());
        String url = "https://img.geonames.org/flags/x/"+country.getCountryCode().toLowerCase()+".gif";


        //Picasso.get().load(url).into((ImageView) holder.view.findViewById(R.id.imageView));
        PicassoTrustAll.getInstance(context).load(url).placeholder(R.drawable.loading).into((ImageView) holder.view.findViewById(R.id.imageView));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Country c = countryList.get(position);
                Intent intent = new Intent(view.getContext(),DetailCountry.class);
                intent.putExtra("Detail",c);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(countryList != null)
            return countryList.size();
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
        }

    }

    public static class SelfSignCertHttpClient {
        public static OkHttpClient getSelfSignOkHttpClient(List<Interceptor> interceptors) {
            try {
                final TrustManager[] trustAllCerts = new TrustManager[] {
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        }
                };

                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
                builder.hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

                for (Interceptor interceptor : interceptors) {
                    builder.addInterceptor(interceptor);
                }

                OkHttpClient okHttpClient = builder.build();
                return okHttpClient;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class PicassoTrustAll {

        private static Picasso mInstance = null;

        private PicassoTrustAll(Context context) {
            List<Interceptor> interceptors = new ArrayList<>();
            // Add any interceptors you wish (e.g Authorization Header interceptor)

            mInstance = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(SelfSignCertHttpClient.getSelfSignOkHttpClient(interceptors)))
                    .listener((picasso, uri, exception) -> Log.e("PICASSO", exception.getMessage())).build();

        }

        public static Picasso getInstance(Context context) {
            if (mInstance == null) {
                new PicassoTrustAll(context);
            }
            return mInstance;
        }
    }
}
