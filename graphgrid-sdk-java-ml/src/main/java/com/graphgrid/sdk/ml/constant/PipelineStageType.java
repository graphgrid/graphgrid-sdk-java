package com.graphgrid.sdk.ml.constant;

public final class PipelineStageType
{

    public static final String ESTIMATOR = "Estimator";
    public static final String TRANSFORMER = "Transformer";

    // Feature
    public static final String INDEX_TO_STRING = "IndexToString";
    public static final String STRING_INDEXER = "StringIndexer";
    public static final String VECTOR_ASSEMBLER = "VectorAssembler";
    public static final String WORD2VEC = "Word2Vec";
    public static final String TOKENIZER = "Tokenizer";
    public static final String STOP_WORDS_REMOVER = "StopWordsRemover";
    public static final String N_GRAM = "NGram";
    public static final String FEATURE_HASHER = "FeatureHasher";
    public static final String ONE_HOT_ENCODER_ESTIMATOR = "OneHotEncoderEstimator";

    // Classification
    public static final String LOGISTIC_REGRESSION = "LogisticRegression";
    public static final String DECISION_TREE_CLASSIFIER = "DecisionTreeClassifier";
    public static final String RANDOM_FOREST_CLASSIFIER = "RandomForestClassifier";

    // Regression
    public static final String LINEAR_REGRESSION = "LinearRegression";

    // Clustering
    public static final String KMEANS = "KMeans";

    // Recommendation
    public static final String ALS = "ALS";
}
