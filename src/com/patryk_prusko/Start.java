package com.patryk_prusko;

import com.patryk_prusko.model.Artist;
import com.patryk_prusko.model.Datasource;

import java.util.List;

public class Start {

    public static void main(String[] args) {


        Datasource datasource = new Datasource();

        if( ! datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_DESC);
        if(artists == null) {
            System.out.println("no artists!");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", NAME = " + artist.getName());
        }


        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);

        for(String album : albumsForArtist) {
            System.out.println("name: " + album);
        }




        datasource.close();
    }
}
