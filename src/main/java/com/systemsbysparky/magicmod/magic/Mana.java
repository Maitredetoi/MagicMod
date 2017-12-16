package com.systemsbysparky.magicmod.magic;

public class Mana implements IMana{
    private int mana;
    private int maxmana;

    public Mana() {
        mana = 100;
        maxmana =100;
    }

    @Override
    public void drain(int points) {
        mana -= points;

    }

    @Override
    public void fill(int points) {
        mana += points;

    }

    @Override
    public void setmax(int points) {
        maxmana = points;

    }

    @Override
    public void setcurrent(int points) {
        mana = points;

    }

    @Override
    public int getmax() {
        return maxmana;
    }

    @Override
    public int getcurrent() {
        return mana;
    }
}
