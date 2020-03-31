package com.univ_amu.localizcci.data;

import android.content.Context;
import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.data.database.Dao;
import com.univ_amu.localizcci.data.database.Database;
import com.univ_amu.localizcci.data.network.Converters;
import com.univ_amu.localizcci.data.network.Network;
import com.univ_amu.localizcci.data.network.NetworkSpot;
import com.univ_amu.localizcci.ui.MapFragment;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private final Context context;
    private final ExecutorService executor;
    private Dao dao;

    public Repository(Context context) {
        this.context = context;
        this.dao = null;
        executor = Executors.newSingleThreadExecutor();
        this.addCategoriesIfEmpty();
        this.addSpotsIfEmpty(); // this , this ,,, this
    }

    private Dao dao() {
        if (dao==null) {
            Database database = Database.getInstance(context);
            this.dao = database.dao();
        }
        return this.dao;
    }

    public LiveData<Integer> getCategoryCount() {return dao().getCategoryCount();}

    public LiveData<Integer> getSpotCount() {return dao().getSpotCount();}

    public LiveData<List<Category>> getCategories() { return dao().getCategories(); }

    public LiveData<List<Spot>> getSpots(int categoryId) {

        return dao().getSpots(categoryId); }

    public LiveData<List<Spot>> getSpots() {


        return dao().getSpots();
    }

    public LiveData<Spot> getSpot(int id) {
        //downloadSpot(id); // impot
        return dao().getSpot(id);
    }

    public void insertSpot(Spot spot) { executor.execute(() -> dao().insertSpot(spot));}


    public void insertSpots(List<Spot> spots) {
        executor.execute(() -> dao().insertSpots(spots));
    }

    public void insertCategories(List<Category> categories) {
        executor.execute(() -> dao().insertCategories(categories));
    }


    public void addCategoriesIfEmpty() {
        getCategoryCount().observeForever(value -> {
            if (value != 0) return;
            addCategories();

        });
    }

    private void addCategories() {
         insertCategories(this.categories);
         //addSpots();

    }

    public void addSpotsIfEmpty (){
        getSpotCount().observeForever(value -> {
            if (value != 0) return;
            addSpots();
        });
    }

    private void addSpots() {
        insertSpots(this.spots);
    }

    public static    String description [] ={"Avec le Panier d’un côté et Notre Dame de la Garde de l’autre le Vieux Port est " +
            "le centre où les locaux et touristes se retrouvent pour prendre un verre en terrasse ou se balader." +
            "Prenez le ferry que Marcel Pagnol aimait, pour passer d’un quai à l’autre.", "Le Château d’If, une forteresse et prison construite sous l’ordre de François I," +
            " est le lieu où le Comte de Monte Cristo fut enfermé dans le roman d’Alexandre Dumas." ,"grand centre commercial tout neuve propre avec tout ce qu il faut pour passer" +
            "une après midi mais le plus beau c est au 3ème étage une immense terrasse avec une magnifique vue sur le port"};

    public static int[] imgId ={R.drawable.incontournables,R.drawable.monuments,R.drawable.nature,R.drawable.shopping};



    private static List<Category> categories = Arrays.asList(
            new Category(0,"Incontounables", "Ce que tu ne dois pas louper",imgId[0]),
            new Category(1,"Monuments & Musées", "Les classiques historiques" ,imgId[1]),
            new Category(2,"Nature", "Decouvrir le paysage" ,imgId[2]),
            new Category(3,"Shopping", "Acheter un truc" ,imgId[3]));

    private static String urls []= {
            "https://www.marseilletourisme.fr/media/filer_public/2019/06/04/quartier-vieux-port.jpg",
            "https://www.marseilletourisme.fr/media/filer_public_thumbnails/filer_public/2019/02/28/cathedrale-major.jpg__4608x3456_q85_crop_subsampling-2.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Calanques_de_Marseille.JPG/800px-Calanques_de_Marseille.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Etoile-chemin-balis%C3%A958.jpg/800px-Etoile-chemin-balis%C3%A958.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/TDP_Exterior.jpg/800px-TDP_Exterior.jpg",
            "https://www.toute-la-franchise.com/images/zoom/bchef-centre-commercial-centre-bourse-marseille.jpg",
            //"",
    };

    private static List<Spot> spots = Arrays.asList(
            new Spot(0,1," Vieux port",new Date(),description[0],43.3,5.4
                    ,"https://www.marseilletourisme.fr/media/filer_public/2019/06/04/quartier-vieux-port.jpg"),
            new Spot(1, 2," Cathédrale de la Major",new Date()," Cathédrale de la Major: description dynamique ",3.3,5.54
                    ,"https://www.marseilletourisme.fr/media/filer_public_thumbnails/filer_public/2019/02/28/cathedrale-major.jpg__4608x3456_q85_crop_subsampling-2.jpg"),
            new Spot(0,3," Château d'If  ",new Date(),description[1],66.3,85.4
                    ,"https://www.marseilletourisme.fr/media/filer_public_thumbnails/filer_public/2019/03/04/chateau-if-marseille.jpg__850x600_q85_crop_subject_location-692%2C239_subsampling-2_upscale.jpg"),
            new Spot(2, 4," Calanques de Marseille",new Date()," Calanques de Marseille : description dynamique ",66.3,53.45
                    ,  "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Calanques_de_Marseille.JPG/800px-Calanques_de_Marseille.JPG"),
            new Spot(1,5," Château d'If  ",new Date(),description[1],43.3,5.4
                    ,"https://www.marseilletourisme.fr/media/filer_public_thumbnails/filer_public/2019/03/04/chateau-if-marseille.jpg__850x600_q85_crop_subject_location-692%2C239_subsampling-2_upscale.jpg"),
            new Spot(2,6,"  le massif de l'Étoile   ",new Date()," le massif de l'Étoile  : description dynamique ",44.7,5.25
                    ,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Etoile-chemin-balis%C3%A958.jpg/800px-Etoile-chemin-balis%C3%A958.jpg"),
            new Spot(3,7,"  Les Terrasses du Port  ",new Date(),description[2],33.3,5.4
                    ,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/TDP_Exterior.jpg/800px-TDP_Exterior.jpg"),
            new Spot(3,8,"  Centre Commercial Centre Bourse  ",new Date(),"  Centre Commercial Centre Bourse  : description dynamique ",49.2,5.4
                    ,"https://www.toute-la-franchise.com/images/zoom/bchef-centre-commercial-centre-bourse-marseille.jpg"),

            new Spot(0, 9," Calanques de Marseille",new Date()," Calanques de Marseille : description dynamique ",66.3,53.45
                    ,  "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Calanques_de_Marseille.JPG/800px-Calanques_de_Marseille.JPG"),

            new Spot(0,10,"  le massif de l'Étoile   ",new Date()," le massif de l'Étoile  : description dynamique ",44.7,5.25
                    ,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Etoile-chemin-balis%C3%A958.jpg/800px-Etoile-chemin-balis%C3%A958.jpg")
            );



    public LiveData<Boolean> downloadSpot(Integer id) {
        MutableLiveData<Boolean> result = new MutableLiveData<>();
        Network.getService(context).getSpot(id).enqueue(new Callback<NetworkSpot>() {
            @Override
            public void onResponse(Call<NetworkSpot> call, Response<NetworkSpot> response) {
                if (!response.isSuccessful()) {
                    result.postValue(false);
                } else {
                    insertNetworkSpot(response.body());
                    result.postValue(true);
                }
            }

            @Override
            public void onFailure(Call<NetworkSpot> call, Throwable t) {
                result.postValue(false);
            }
        });
        return result;
    }

    public void insertNetworkSpot(NetworkSpot networkSpot) {
        insertSpot(Converters.getSpot(networkSpot));
    }




}

