package com.alejandrocorrero.room.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;

import com.alejandrocorrero.room.BR;
import com.alejandrocorrero.room.R;
import com.alejandrocorrero.room.utils.Utils;
import com.squareup.picasso.Picasso;

@Entity(tableName = "companies", indices = {@Index(value = {"name"})})
public class Company extends BaseObservable {
    @PrimaryKey
    @NonNull
    private String CIF;
    private String address;
    @NonNull
    private String name;
    private String phone;
    private String email;
    private String logo;
    private String person;


    @Ignore
    public Company(@NonNull String CIF, String address, @NonNull String name, String phone, String email, String logo, String person) {
        this.CIF = CIF;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.logo = logo;
        this.person = person;
    }

    public Company() {
    }

    @NonNull
    @Bindable
    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
        notifyPropertyChanged(BR.cIF);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
        notifyPropertyChanged(BR.logo);
    }

    @Bindable
    @NonNull
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
        notifyPropertyChanged(BR.person);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.no_image_available)
                    .error(R.drawable.no_image_available)
                    .into(view);
        }else{
            Picasso.with(view.getContext())
                    .load(R.drawable.no_image_available)
                    .placeholder(R.drawable.no_image_available)
                    .error(R.drawable.no_image_available)
                    .into(view);
        }
    }

    @Bindable({"name", "CIF", "logo"})
    public boolean isEnable() {
        return !(TextUtils.isEmpty(name) || !(Utils.isCifNumValid(CIF)));

    }


}
