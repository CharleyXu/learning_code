package com.xu.algorithm.structure.string;

import lombok.extern.slf4j.Slf4j;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Arrays;
import java.util.Collection;

@Slf4j
public class AC {

    public static void main(String[] args) {
        String[] words = new String[]{"null", "ERROR", "exception"};
        String string = "2022-10-25 10:53:19,000 2021-03-13T18:05:56Z [2266] ERROR [be9ea] {rocksdb} rocksdb: [util/sst_file_manager_impl.cc:277] free space [20480 bytes] is less than required disk [be9ea]arangodb {rocksdb} rocksdb: [util/sst_file_manager_impl.cc:277] free space [20480 bytes] is less than required disk 4:硬件异常";
        String string2 = "2022-10-25 07:45:30,000 ERROR c.b.h.t.s.SimulateErrorLogService [http-nio-18394-exec-1] java.util.ArrayList.rangeCheck(ArrayList.java:657)\n" +
                "java.util.ArrayList.get(ArrayList.java:433)\n" +
                "com.bizseer.hubble.toolcli.service.SimulateErrorLogService.buildNotFountExceptionMethod2(SimulateErrorLogService.java:31)\n" +
                "com.bizseer.hubble.toolcli.service.SimulateErrorLogService.buildNotFountExceptionMethod1(SimulateErrorLogService.java:23)\n" +
                "com.bizseer.hubble.toolcli.service.SimulateErrorLogService.buildNotFountException(SimulateErrorLogService.java:18)\n" +
                "com.bizseer.hubble.toolcli.controller.SimulateErrorLogController.simulateNotFoundException(SimulateErrorLogController.java:20)\n" +
                "sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)";
        log.info("{}", containsWordsAhoCorasick(string, words));
        log.info("{}", containsWordsAhoCorasick(string2, words));
    }

    public static boolean containsWordsAhoCorasick(String inputString, String[] words) {
        Trie trie = Trie.builder().onlyWholeWords().addKeywords(words).build();
        Collection<Emit> emits = trie.parseText(inputString);
        log.info("{}", emits);
        boolean found = true;
        for (String word : words) {
            boolean contains = Arrays.toString(emits.toArray()).contains(word);
            if (!contains) {
                found = false;
                break;
            }
        }
        return found;
    }

}
