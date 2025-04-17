package br.edu.insper.insperclicker.repository;

import br.edu.insper.insperclicker.game.common.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String>
{
    Player findByName(String name);
}
