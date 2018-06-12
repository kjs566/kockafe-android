package com.kjs566.kockafe.feature.repository;

import com.kjs566.kockafe.feature.R;
import com.kjs566.kockafe.feature.model.CatRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatsRepository {
    private static final String BOREK_ID = "borek";
    private static final String STELLA_ID = "stella";
    private static final String MINNIE_ID = "minnie";
    private static final String NOXIK_ID = "noxik";
    private static final String OLIVER_ID = "oliver";
    private static final String MUFFIN_ID = "muffin";
    private static final String TERINKA_ID = "terinka";

    private static final String[] CATS_IDS = {BOREK_ID, STELLA_ID, MINNIE_ID, NOXIK_ID, OLIVER_ID, MUFFIN_ID, TERINKA_ID};
    private static final int[] CATS_NAMES = {R.string.cat_name_borek, R.string.cat_name_stella, R.string.cat_name_minnie, R.string.cat_name_noxik, R.string.cat_name_oliver, R.string.cat_name_muffin, R.string.cat_name_terinka};
    private static final int[] CATS_DESCRIPTIONS = {R.string.cat_description_borek, R.string.cat_description_stella, R.string.cat_description_minnie, R.string.cat_description_noxik, R.string.cat_description_oliver, R.string.cat_description_muffin, R.string.cat_description_terinka};
    private static final int[][] CATS_IMAGES = {
            {
                R.drawable.borek00, R.drawable.borek01, R.drawable.borek02, R.drawable.borek03, R.drawable.borek04
            }, {
                R.drawable.stella00, R.drawable.stella01, R.drawable.stella02
            }, {
                R.drawable.minnie00, R.drawable.minnie01, R.drawable.minnie02
            }, {
                R.drawable.nox00, R.drawable.nox01, R.drawable.nox02, R.drawable.nox03, R.drawable.nox04
            }, {
                R.drawable.oli00, R.drawable.oli01, R.drawable.oli02, R.drawable.oli03, R.drawable.oli04, R.drawable.oli05, R.drawable.oli06
            }, {
                R.drawable.mufi00, R.drawable.mufi01, R.drawable.mufi02, R.drawable.mufi03, R.drawable.mufi04
            }, {
                R.drawable.teri00, R.drawable.teri01, R.drawable.teri02, R.drawable.teri03
            }
    };


    private static final List<CatRecord> sCatsList = new ArrayList<>(CATS_IDS.length);
    static{
        for(int i = 0; i < CATS_IDS.length; i++){
            sCatsList.add(new CatRecord(CATS_IDS[i], CATS_NAMES[i], CATS_DESCRIPTIONS[i], CATS_IMAGES[i]));
        }
    }
    private static final Map<String, CatRecord> sCatsMap = new HashMap<>();
    static{
        for(int i = 0; i < CATS_IDS.length; i++){
            sCatsMap.put(CATS_IDS[i], sCatsList.get(i));
        }
    }


    private static CatsRepository sInstance;

    public static CatsRepository getInstance(){
        if(sInstance == null)
            sInstance = new CatsRepository();
        return sInstance;
    }

    public List<CatRecord> getCatsList(){
        return sCatsList;
    }

    public CatRecord getCatById(String id){
        return sCatsMap.get(id);
    }
}