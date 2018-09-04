import java.net.MalformedURLException;

public class ModuleEngine {

    public static void main(String[] args) throws MalformedURLException {
        String modulePath = args[0];
        /*
          Создаем загрузчик модулей.
         */
        ModuleLoader loader = new ModuleLoader(ClassLoader.getSystemClassLoader(), modulePath);
        //URLClassLoader loader = new URLClassLoader(new URL[]{new URL( "file:C:\\Users\\Егорка\\IdeaProjects\\test\\out\\production\\test\\classLoaderPractik")});

        /*
         * Загружаем и исполняем каждый модуль.
         */
        try {
            String moduleName = "ModulePrinter";
            System.out.println(moduleName);
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
