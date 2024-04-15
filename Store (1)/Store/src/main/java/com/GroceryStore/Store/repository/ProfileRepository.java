// ProfileRepository.java
package com.GroceryStore.Store.repository;

import com.GroceryStore.Store.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByLoginId(int loginId);
}
