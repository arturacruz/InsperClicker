package br.edu.insper.coffeeclicker;

import br.edu.insper.coffeeclicker.game.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main
{

	public static void main(String[] args)
	{
		SpringApplication.run(Main.class, args);
		Game.start();
	}

}
