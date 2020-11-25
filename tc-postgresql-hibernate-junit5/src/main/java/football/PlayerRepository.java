/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2020-2020 the original author or authors.
 */

package football;

import football.entity.Player;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlayerRepository {

    private final EntityManager entityManager;

    public PlayerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Player> findAll() {
        TypedQuery<Player> fromPlayer
                = entityManager.createQuery("FROM Player", Player.class);
        return fromPlayer.getResultList();
    }

}
