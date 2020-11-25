package com.example.examenad.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "usoagenda",
        foreignKeys = @ForeignKey(entity = Persona.class,
                parentColumns = "id",
                childColumns = "idpersona",
                onDelete = ForeignKey.CASCADE))
public class UsoPersona {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "idpersona")
    private int idpersona;

    @NonNull
    @ColumnInfo(name = "uso")
    private String uso;

    public UsoPersona(int idpersona, @NonNull String uso) {
        this.idpersona = idpersona;
        this.uso = uso;
    }

    public int getId() {
        return id;
    }

    public int getIdpersona() {
        return idpersona;
    }

    @NonNull
    public String getUso() {
        return uso;
    }
}
