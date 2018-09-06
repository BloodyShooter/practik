package org.gvozdetscky.classLoaderPractik;

public class ModuleEngine {

    private static final String jarFilePath = "C:\\Users\\Егорка\\IdeaProjects\\test\\out\\artifacts\\test_jar\\test.jar";
    private static final String packegeName = "org.gvozdetscky.classLoaderPractik";

    public static void main(String[] args) {

        /*
          Создаем загрузчик модулей.
         */
        ModuleLoader loader = new ModuleLoader(
                jarFilePath,
                packegeName
        );

        /*
         * Загружаем и исполняем каждый модуль.
         */
        try {
            String moduleName = "ModulePrinter";
            Class clazz = loader.loadClass(moduleName);
            Object newInst = clazz.newInstance();

            if (!(newInst instanceof Module)) {
                System.out.println("Не скастовать");
                return;
            }

            Module execute = (Module) newInst;

            execute.load();
            execute.run();
            execute.unload();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
