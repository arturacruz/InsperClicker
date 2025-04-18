package br.edu.insper.insperclicker.repository;

import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<PlayerModel, String>
{
    PlayerModel findByName(String name);
}
