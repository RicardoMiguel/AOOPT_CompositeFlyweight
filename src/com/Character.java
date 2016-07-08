package com;

import java.util.HashMap;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class Character implements IDocumentPart {
    private static HashMap<java.lang.Character, Character> characters;
    private char character;

    public static Character getCharacter(char c){
        if(characters == null){
            characters = new HashMap<>();
        }

        c = java.lang.Character.toLowerCase(c);
        Character character = characters.get(c);
        if(character == null){
            character = new Character(c);
            characters.put(c, character);
        }
        return character;
    }

    public Character(char character) {
        this.character = character;
    }

    @Override
    public String print(IDocumentPartVisitor iDocumentPartVisitor) {
        return iDocumentPartVisitor.print(this, false);
    }

    public char getCharacter() {
        return character;
    }
}
