package com.freiz.client.utility;

import data.SpaceMarine;
import data.Weapon;

import java.time.ZonedDateTime;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Optional;
import java.util.List;

public class CollectionManager {
    private static HashSet<Long> hashSetId = new HashSet<>();
    private static Long idIter = 0L;
    private HashSet<Long> ids = new HashSet<>();
    private HashSet<SpaceMarine> spaceMarinesCollection = new HashSet<>();
    private ZonedDateTime creationDate = ZonedDateTime.now();

    public void initialiseData(HashSet<SpaceMarine> hashSet) {
        this.spaceMarinesCollection = hashSet;
        for (SpaceMarine spaceMarine : spaceMarinesCollection) {
            ids.add(spaceMarine.getId());
        }
    }
    public int size() {
        return spaceMarinesCollection.size();
    }
    public boolean removeIf(Long longArg) {
        return spaceMarinesCollection.removeIf(x -> x.getId() == longArg);
    }
    public Class<? extends HashSet> getClassCOllection() {
        return spaceMarinesCollection.getClass();
    }
    public void filterByWeaponType(Weapon inpEnum, StringJoiner output) {
        for (SpaceMarine spaceMarine : spaceMarinesCollection) {
            Weapon weaponType = spaceMarine.getWeaponType();
            if (weaponType == null) {
                weaponType = Weapon.MULTI_MELTA;
            }
            if (weaponType.compareTo(inpEnum) == 0) {
                output.add(spaceMarine.toString());
            }
        }
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
        hashSetId.add(idIter);
        return idIter;
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
}

