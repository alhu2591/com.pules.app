package com.pules.app.domain.usecase

import com.pules.app.domain.model.Article
import javax.inject.Inject

class ClassifyArticleUseCase @Inject constructor() {

    private val categoryKeywords = mapOf(
        "Technology" to listOf("tech", "software", "AI", "artificial intelligence", "gadgets", "cybersecurity", "programming", "developer", "startup"),
        "Politics" to listOf("government", "election", "policy", "president", "congress", "senate", "democracy", "political"),
        "Sports" to listOf("football", "basketball", "soccer", "baseball", "olympics", "athlete", "game", "match", "team"),
        "Business" to listOf("economy", "market", "finance", "stocks", "company", "investment", "CEO", "business"),
        "Science" to listOf("research", "discovery", "space", "biology", "physics", "chemistry", "astronomy", "scientific"),
        "Health" to listOf("medical", "health", "wellness", "disease", "cure", "fitness", "nutrition", "hospital"),
        "Entertainment" to listOf("movie", "film", "music", "celebrity", "hollywood", "tv", "show", "art", "culture"),
        "World News" to listOf("global", "international", "conflict", "war", "peace", "diplomacy", "country", "nation")
    )

    operator fun invoke(article: Article): String {
        val text = (article.title + " " + (article.description ?: "")).lowercase()

        for ((category, keywords) in categoryKeywords) {
            if (keywords.any { text.contains(it) }) {
                return category
            }
        }
        return "General" // Default category if no keywords match
    }
}

