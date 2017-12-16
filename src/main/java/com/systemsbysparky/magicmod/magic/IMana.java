package com.systemsbysparky.magicmod.magic;

public interface IMana {
    void drain(int points);
    void fill(int points);
    void setmax(int points);
    void setcurrent(int points);
    int getmax();
    int getcurrent();

}
