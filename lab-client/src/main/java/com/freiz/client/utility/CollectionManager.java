package com.freiz.client.utility;

import com.freiz.client.exception.NotMaxException;
import com.freiz.client.exception.NotMinException;
import data.SpaceMarine;
import data.Weapon;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionManager {
    private final HashSet<Long> hashSetId = new HashSet<>();
    private Long idIter = 1L;
    private HashSet<SpaceMarine> spaceMarinesCollection = new HashSet<>();
    private ZonedDateTime creationDate = ZonedDateTime.now();

    public void initialiseData(HashSet<SpaceMarine> hashSet) {
        this.spaceMarinesCollection = hashSet;
        for (SpaceMarine spaceMarine : spaceMarinesCollection) {
            hashSetId.add(spaceMarine.getId());
        }
    }
    public int size() {
        return spaceMarinesCollection.size();
    }
    public boolean removeIdIfMatchArg(Long longArg) {
        return spaceMarinesCollection.removeIf(x -> x.getId() == longArg);
    }
    public Class<? extends HashSet> getClassCOllection() {
        return spaceMarinesCollection.getClass();
    }
    public String filterByWeaponType(Weapon inpEnum) {
         return this.spaceMarinesCollection.stream().filter(e -> e.getWeaponType().equals(inpEnum)).map(Objects::toString).collect(Collectors.joining("\n"));
    }

    public HashSet<SpaceMarine> getSpaceMarinesCollection() {
        return spaceMarinesCollection;
    }

    public void removeId(Long id) {
        hashSetId.remove(id);
    }
    public boolean isEmpty() {
        return spaceMarinesCollection.isEmpty();
    }

    public void clear() {
        hashSetId.clear();
        spaceMarinesCollection.clear();
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getNewID() {
        while (hashSetId.contains(idIter)) {
            idIter++;
        }
        return idIter;
    }
    public void addMin(SpaceMarine spaceMarine) throws NotMinException {
        if (getMinHeartCount() > spaceMarine.getHeartCount()) {
            add(spaceMarine);
        } else {
            throw new NotMinException();
        }
    }

    public boolean removeByID(Long id) {
        if (spaceMarinesCollection.stream().anyMatch(x -> x.getId().equals(id))) {
            SpaceMarine spaceMarine = spaceMarinesCollection.stream().filter(x -> x.getId().equals(id)).findAny().get();
            hashSetId.remove(spaceMarine.getId());
            spaceMarinesCollection.remove(spaceMarine);
            removeId(id);
            return true;
        }
        return false;
    }

    public void add(SpaceMarine spaceMarine) {
        spaceMarine.setId(getNewID());
        hashSetId.add(spaceMarine.getId());
        spaceMarinesCollection.add(spaceMarine);
    }

    public void update(SpaceMarine spaceMarine) {
        spaceMarinesCollection.removeIf(x -> x.getId() == spaceMarine.getId());
        spaceMarinesCollection.add(spaceMarine);
    }

    public int getMinHeartCount() {
        Optional<Integer> minHeartCount = spaceMarinesCollection.stream().map(SpaceMarine::getHeartCount).min(Integer::compare);
        return minHeartCount.orElse(0);
    }
    public int getMaxHeartCount() {
        Optional<Integer> maxHeartCount = spaceMarinesCollection.stream().map(SpaceMarine::getHeartCount).max(Integer::compare);
        return maxHeartCount.orElse(0);
    }

    public List<SpaceMarine> filterGreaterThanHeartCount(int heartCount) {
        return this.spaceMarinesCollection.stream().filter(spaceMarine -> spaceMarine.getHeartCount() > heartCount).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return spaceMarinesCollection.toString();
    }

    public void addMax(SpaceMarine spaceMarine) throws NotMaxException {
        if (getMaxHeartCount() < spaceMarine.getHeartCount()) {
            add(spaceMarine);
        } else {
            throw new NotMaxException();
        }
    }

    public boolean isHaveId(Long id) {
        return spaceMarinesCollection.stream().anyMatch((x -> x.getId().equals(id)));
    }
}

