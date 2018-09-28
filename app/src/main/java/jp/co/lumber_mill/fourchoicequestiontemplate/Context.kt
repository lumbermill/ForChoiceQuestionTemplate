package jp.co.lumber_mill.fourchoicequestiontemplate

class Context {
    companion object {
        val questions: HashMap<String, ArrayList<ArrayList<String>>> = hashMapOf(
                "animal" to arrayListOf(
                        arrayListOf("hedgehog","dog","turkey","cow"),
                        arrayListOf("cow","shrimp","squid","horse"),
                        arrayListOf("pig","bonito","crab","squid"),
                        arrayListOf("cat","monkey","mouse","deer"),
                        arrayListOf("dog","mouse","deer","panda"),
                        arrayListOf("monkey","money","monk","mosquito"),
                        arrayListOf("mouse","monkey","crab","tuna"),
                        arrayListOf("giraffe","deer","tuna","squid"),
                        arrayListOf("bird","sheep","shrimp","bonito"),
                        arrayListOf("horse","bonito","mouse","sheep"),
                        arrayListOf("deer","bear","lion","cow"),
                        arrayListOf("panda","bird","monkey","punk")                ),
                "fish" to arrayListOf(
                        arrayListOf("","","","")
                )
        )
    }
}
