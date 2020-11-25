package com.example.examenad.model.room;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.examenad.model.entity.Persona;
import com.example.examenad.model.entity.UsoPersona;
import com.example.examenad.model.dao.AgendaDao;

import static com.example.examenad.AgendaApplication.EjecutorDeHilos;

@Database(entities = {Persona.class, UsoPersona.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    public abstract AgendaDao getAgendaDao();
    private volatile static AgendaDatabase INSTANCE;

    public static AgendaDatabase getDatabase(Application context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AgendaDatabase.class, "dbpalabro")
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            EjecutorDeHilos.execute(() -> {
                AgendaDao dao = INSTANCE.getAgendaDao();
                dao.deleteAll();
            });
        }
    };

    public static AgendaDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgendaDatabase.class, "dbpalabro").addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
