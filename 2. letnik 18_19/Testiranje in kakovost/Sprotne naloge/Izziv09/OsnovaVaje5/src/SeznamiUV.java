
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class SeznamiUV {

    private String memoryError = "Error: not enough memory, operation failed";
    HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;

    public SeznamiUV() {
        seznami = new HashMap<>();
        seznami.put("pv", new PrioritetnaVrsta<>());
        seznami.put("sk", new Sklad<>());
        seznami.put("bst", new Bst<>());
        seznami.put("23", new Drevo23<>());
    }
    
    public void addImpl(String key, Seznam<String> seznam) {
        seznami.put(key, seznam);
    }

    public String processInput(String input) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(input);
        String token;
        String result = "OK";
        if (sc.hasNext()) {
            token = sc.next();
        } else {
            return "Error: enter command";
        }
        if (!token.equals("use") && !token.equals("exit") && (null == seznam)) {
            return "Error: please specify a data structure (use {pv|sk|bst|23})";
        }
        try {
            switch (token) {
                case "use":
                    if (sc.hasNext()) {
                        seznam = seznami.get(sc.next());
                        if (null == seznam) {
                            result = "Error: please specify a correct data structure type {pv|sk|bst|23}";
                        }
                    } else {
                        result = "Error: please specify a data structure type {pv|sk|bst|23}";
                    }
                    break;
                case "add":
                    if (sc.hasNext()) {
                        seznam.add(sc.next());
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                case "remove_first":
                    result = seznam.removeFirst();
                    break;
                case "getfirst":
                    result = seznam.getFirst();
                    break;
                case "size":
                    result = seznam.size() + "";
                    break;
                case "depth":
                    result = seznam.depth() + "";
                    break;
                case "is_empty":
                    result = "Data structure is " + (seznam.isEmpty() ? "" : "not ") + "empty.";
                    break;
                case "reset":
                    while (!seznam.isEmpty()) {
                        seznam.removeFirst();
                    }
                    break;
                case "exists":
                    if (sc.hasNext()) {
                        result = "Element " + (seznam.exists(sc.next()) ? "exists " : "doesn't exist ") + "in data structure.";
                        seznam.exists(sc.next());
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                case "remove":
                    if (sc.hasNext()) {
                        result = seznam.remove(sc.next());
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                case "asList":
                    if (!seznam.isEmpty()) {
                        result = "";
                        List<String> beri = new ArrayList<>();
                        beri = seznam.asList();
                        for (int i = 0; i < beri.size(); i++) {
                            if (result == "") {
                                result = beri.get(i);
                            } else {
                                result = result + beri.get(i);
                            }
                            int j = i + 1;
                            if (j < beri.size()) {
                                result = result + ", ";
                            }

                        }
                    }
                    break;

                case "print":
                    seznam.print();
                    break;

                case "save":
                    if (sc.hasNext()) {
                        seznam.save(new FileOutputStream(sc.next()));
                    } else {
                        result = "Error: please specify a file name";
                    }
                    break;
                case "restore":
                    if (sc.hasNext()) {
                        seznam.restore(new FileInputStream(sc.next()));
                    } else {
                        result = "Error: please specify a file name";
                    }
                    break;
                case "exit":
                    result = "Have a nice day.";
                    break;

                default:
                    result = "Error: invalid command";
            }
        } catch (java.util.NoSuchElementException e) {
            result = "Error: data structure is empty";
        } catch (IOException e) {
            result = "Error: IO error " + e.getMessage();
        } catch (ClassNotFoundException e) {
            result = "Error: Unknown format";
        } catch (OutOfMemoryError e) {
            System.err.println(memoryError);
            return memoryError;
        }

        return result;
    }

}
