package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false,
                "help : вывести справку по доступным командам\n"
                        + "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"
                        + "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"
                        + "add {element} : добавить новый элемент в коллекцию\n"
                        + "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"
                        + "remove_by_id id : удалить элемент из коллекции по его id\n"
                        + "clear : очистить коллекцию\n"
                        + "save : сохранить коллекцию в файл\n"
                        + "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"
                        + "exit : завершить программу (без сохранения в файл)\n"
                        + "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n"
                        + "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n"
                        + "history : вывести последние 6 команд (без их аргументов)\n"
                        + "count_less_than_melee_weapon meleeWeapon : вывести количество элементов, значение поля meleeWeapon которых меньше заданного\n"
                        + "count_greater_than_heart_count heartCount : вывести количество элементов, значение поля heartCount которых больше заданного\n"
                        + "filter_by_weapon_type weaponType : вывести элементы, значение поля weaponType которых равно заданному");
    }
}

