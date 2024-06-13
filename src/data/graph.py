import matplotlib.pyplot as plt
import numpy as np

# Data from the user
categories = ['dataSize = 5M, stringSize = 10', '5000K, 100', '500K, 1000', '50K, 10000']
indexed_times = {
    'BigBatchArray': [0.05199948, 0.01573618, 0.14754118, 0.07212484],
    'BigBatchParallelArray': [0.02558798, 0.01473606, 0.06413864, 0.03924746],
    'BigBatchArrayList': [0.07577272, 0.01498660, 0.18135878, 0.10485318],
    'BigBatchParallelList': [0.04337702, 0.01277434, 0.07291580, 0.03598602],
    'BigBatchLinkedList': [0.18860142, 0.02282690, 0.16926616, 0.07628300],
    'BigBatchMap': [0.13538196, 0.02296786, 0.18795630, 0.08987014]
}

non_indexed_times = {
    'BigBatchArray': [0.18163150, 0.12719310, 1.10493642, 1.02000174],
    'BigBatchParallelArray': [0.19113044, 0.07106486, 0.34660914, 0.26109361],
    'BigBatchArrayList': [0.39744190, 0.13795072, 1.19194508, 0.87136534],
    'BigBatchParallelList': [0.08173558, 0.07630022, 0.42324698, 0.47200308],
    'BigBatchLinkedList': [0.75528213, 0.12793760, 1.05654324, 1.01666186],
    'BigBatchMap': [0.75790814, 0.16858742, 1.21179384, 0.82535414]
}

# 색상 설정
colors = {
    'BigBatchArray': 'crimson',
    'BigBatchParallelArray': 'coral',
    'BigBatchArrayList': 'gold',
    'BigBatchParallelList': 'limegreen',
    'BigBatchLinkedList': 'deepskyblue',
    'BigBatchMap': 'cyan'
}

x = np.arange(len(categories))  # the label locations
width = 0.35  # the width of the bars

fig, ax = plt.subplots(figsize=(14, 8))

# 인덱스를 사용한 시간 데이터 그리기
for i, (label, times) in enumerate(indexed_times.items()):
    ax.bar(x + (i-3)*width/6, times, width/6, label=f'{label} (Indexed)', color=colors[label])

# 인덱스를 사용하지 않은 시간 데이터 그리기
for i, (label, times) in enumerate(non_indexed_times.items()):
    ax.bar(x + (i+3)*width/6, times, width/6, label=f'{label} (Non-Indexed)', color=colors[label], hatch='//')

# Add some text for labels, title and custom x-axis tick labels, etc.
ax.set_xlabel('Data Size, Batch Size')
ax.set_ylabel('Average Time (seconds)')
ax.set_title('Comparison of Average Times with and without Indexes')
ax.set_xticks(x)
ax.set_xticklabels(categories)
ax.legend()

fig.tight_layout()

plt.show()
