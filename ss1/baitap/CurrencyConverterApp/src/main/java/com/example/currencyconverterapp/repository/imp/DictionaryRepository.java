package com.example.currencyconverterapp.repository.imp;

import com.example.currencyconverterapp.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DictionaryRepository implements IDictionaryRepository  {

    @Override
    public String findDictionary(String dictionary) {
        String englishVocabulary[] = {"Cart" , "Bicycle" , "Motorcycle" , "Scooter" , "Car"};
        String vietNamVocabulary[] = {"xe ngựa" , "xe đạp" , "xe máy" , "xe tay ga" , "ô tô"};
        String dictionary1 = dictionary;
        String dictionary2 = "find not found";
        for (int i = 0; i < englishVocabulary.length; i++) {
            if(englishVocabulary[i].equals(dictionary1)){
                return vietNamVocabulary[i];
            }
        }
        return dictionary2;
    }
}
