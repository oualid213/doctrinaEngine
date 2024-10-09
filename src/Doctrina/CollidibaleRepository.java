package Doctrina;

import java.util.*;
import java.util.function.Consumer;

public class CollidibaleRepository implements Iterable<StaticEntity>{
    private static CollidibaleRepository instance;

    private final List<StaticEntity> registeredEntity;

    private CollidibaleRepository(){
        // Private constructor to prevent class creation
        registeredEntity = new ArrayList<>();
    }

    public static CollidibaleRepository getInstance(){
        if(instance == null){
            return new CollidibaleRepository();
        }
        return instance;
    }

    public void registerStaticEntity(StaticEntity entity){
        registeredEntity.add(entity);
    }
    public void unregisterStaticEntity(StaticEntity entity){
        registeredEntity.remove(entity);
    }
    public void registerStaticEntities(Collection<StaticEntity> entities){
        registeredEntity.addAll(entities);
    }
    public void unregisterStaticEntities(Collection<StaticEntity> entities){
        registeredEntity.removeAll(entities);
    }
    public int count(){
        return registeredEntity.size();
    }

    @Override
    public Iterator<StaticEntity> iterator() {
        return registeredEntity.iterator();
    }


}
