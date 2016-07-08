package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class Paragraph implements IDocumentPart, RLECompressionService{
    private List<Character> characterList ;
    private List<Integer> rleCompression;

    public List<Integer> getRleCompression() {
        return rleCompression;
    }

    public Paragraph(String string) {
        characterList = new ArrayList<>();
        rleCompression = compressString(string);
        for(int i = 0 ; i<string.length();i++){

            characterList.add(Character.getCharacter(string.charAt(i)));
        }
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    @Override
    public String print(IDocumentPartVisitor iDocumentPartVisitor) {
        return iDocumentPartVisitor.print(this);
    }

    @Override
    public List<Integer> compressString(String s) {
        int counter = 0;
        List<Integer> compression = new ArrayList<>();
        boolean upperCase = true;

        for(int i = 0 ; i<s.length();i++){
            char theChar = s.charAt(i);
            if(java.lang.Character.isUpperCase(theChar) && upperCase){
                counter++;
            } else if(java.lang.Character.isLowerCase(theChar) && upperCase) {
                compression.add(counter);
                upperCase = false;
                counter = 1;
            } else if(java.lang.Character.isUpperCase(theChar) && !upperCase){
                compression.add(counter);
                upperCase = true;
                counter = 1;
            } else {
                counter++;
            }
        }

        compression.add(counter);
        return compression;
    }
}
